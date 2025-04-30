import java.util.HashMap;
import java.util.Map;

public class GenericItem {
    private final Map<String, String> attributes = new HashMap<String, String>();
    private String tag;
    private String value;
    private boolean isError = false;

    public GenericItem(String tag) {
        this.tag = tag;
    }

    public GenericItem(String tag, String value) {
        this.tag = tag;
        this.value = value;
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public boolean isError() {
        return isError;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "GenericItem [tag=" + tag + ", value=" + value + ", attributes=" + attributes + "]";
    }
}
