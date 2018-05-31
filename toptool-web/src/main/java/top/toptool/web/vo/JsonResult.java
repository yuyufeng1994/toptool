package top.toptool.web.vo;

/**
 * @author yuyufeng
 * @date 2018/5/31.
 */
public class JsonResult<T> {
    private boolean success;

    private T data;

    private String error;

    public JsonResult() {
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public JsonResult(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
