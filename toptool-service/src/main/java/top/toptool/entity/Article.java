package top.toptool.entity;

import java.util.Date;
import javax.persistence.*;

public class Article {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 概要
     */
    private String general;

    /**
     * 分类
     */
    private String category;

    /**
     * 状态(0:正常 1:锁定)
     */
    private String status;

    /**
     * 来源
     */
    private String source;

    /**
     * 封面
     */
    private String cover;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 内容
     */
    private String content;

    public Article(Long id, String title, String general, String category, String status, String source, String cover, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.title = title;
        this.general = general;
        this.category = category;
        this.status = status;
        this.source = source;
        this.cover = cover;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Article() {
        super();
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取概要
     *
     * @return general - 概要
     */
    public String getGeneral() {
        return general;
    }

    /**
     * 设置概要
     *
     * @param general 概要
     */
    public void setGeneral(String general) {
        this.general = general == null ? null : general.trim();
    }

    /**
     * 获取分类
     *
     * @return category - 分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置分类
     *
     * @param category 分类
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取状态(0:正常 1:锁定)
     *
     * @return status - 状态(0:正常 1:锁定)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0:正常 1:锁定)
     *
     * @param status 状态(0:正常 1:锁定)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取封面
     *
     * @return cover - 封面
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}