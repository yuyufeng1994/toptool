package top.toptool.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;
import top.toptool.dto.KeywordScoreDTO;
import top.toptool.exception.BaseException;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * 文字处理服务
 *
 * @author yuyufeng
 * @date 2017/11/7
 */
@Service
public class TextHandleService {
    /**
     * 关键词重要性成都
     *
     * @param text
     * @param k
     * @return
     */
    public List<KeywordScoreDTO> extractKeywords(String text, Integer k, List<String> stopWords) throws BaseException {
        if (StringUtils.isEmpty(text) || k == null || k < 1 || k > 20 || stopWords.size() > 100) {
            throw new BaseException("请传入正确的传参");
        }
        List<String> keyWords = new ArrayList<>();
        float d = 0.85f;
        /**
         * 标点符号、常用词、以及“名词、动词、形容词、副词之外的词”
         */
        Set<String> stopWordSet = new HashSet<String>();
        for (String stopWord : stopWords) {
            stopWordSet.add(stopWord);
        }

        Analyzer analyzer = new IKAnalyzer(true);
        TokenStream ts = null;
        //分词
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(text));
            OffsetAttribute offset = (OffsetAttribute) ts.addAttribute(OffsetAttribute.class);
            CharTermAttribute term = (CharTermAttribute) ts.addAttribute(CharTermAttribute.class);
            TypeAttribute type = (TypeAttribute) ts.addAttribute(TypeAttribute.class);
            ts.reset();

            while (ts.incrementToken()) {
                if (!stopWordSet.contains(term.toString())) {
                    keyWords.add(term.toString());
                }
            }
            ts.end();
        } catch (IOException var14) {
            var14.printStackTrace();
        } finally {
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException var13) {
                    var13.printStackTrace();
                }
            }

        }

        Map<String, Set<String>> relationWords = new HashMap<>();

        //获取每个关键词 前后k个的组合
        for (int i = 0; i < keyWords.size(); i++) {
            String keyword = keyWords.get(i);
            Set<String> keySets = relationWords.get(keyword);
            if (keySets == null) {
                keySets = new HashSet<>();
                relationWords.put(keyword, keySets);
            }

            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || j >= keyWords.size() || j == i) {
                    continue;
                } else {
                    keySets.add(keyWords.get(j));
                }
            }
        }

        Map<String, Float> score = new HashMap<>();
        float min_diff = 0.01f; //迭代差值趋近于多少则停止
        int max_iter = 100;//最大迭代次数

        //迭代
        for (int i = 0; i < max_iter; i++) {
            Map<String, Float> m = new HashMap<>();
            float max_diff = 0;
            for (String key : relationWords.keySet()) {
                Set<String> value = relationWords.get(key);
                //先给每个关键词一个默认rank值
                m.put(key, 1 - d);
                //一个关键词的TextRank由其它成员投票出来
                for (String other : value) {
                    int size = relationWords.get(other).size();
                    if (key.equals(other) || size == 0) {
                        continue;
                    } else {
                        m.put(key, m.get(key) + d / size * (score.get(other) == null ? 0 : score.get(other)));
                    }
                }
                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 0 : score.get(key))));
            }

            score = m;
            if (max_diff <= min_diff) {
                break;
            }
        }

        List<KeywordScoreDTO> scores = new ArrayList<>();
        for (String s : score.keySet()) {
            KeywordScoreDTO score1 = new KeywordScoreDTO();
            score1.setKey(s);
            score1.setSignificance(score.get(s));
            scores.add(score1);
        }

        scores.sort(new Comparator<KeywordScoreDTO>() {
            @Override
            public int compare(KeywordScoreDTO o1, KeywordScoreDTO o2) {
                if (o2.getSignificance() - o1.getSignificance() > 0) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
        return scores.subList(0, scores.size() > 20 ? 20 : scores.size());
    }
}


