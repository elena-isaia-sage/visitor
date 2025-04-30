import java.util.Map;

public class XmlVisitor implements Visitor {
    private final StringBuilder builder = new StringBuilder();
    private int depth = 0;
    @Override
    public void visit(GenericItem item) {
        String prefix = "";
        if (depth > 0) {
            prefix = "\t".repeat(depth);
        }
        builder.append(prefix);
        builder.append("<").append(item.getTag()).append(">");
        builder.append("value=\"").append(item.getValue()).append("\"");
        for (Map.Entry<String, String> attribute : item.getAttributes().entrySet()) {
            builder.append("\t").append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
        }
        builder.append("</").append(item.getTag()).append(">");
        builder.append("\n");
    }

    @Override
    public void visit(GenericBlock block) {
        String prefix = "";
        if (depth > 0) {
            prefix = "\t".repeat(depth);
        }
        builder.append(prefix);
        builder.append("<").append(block.getTag());

        if (!block.getAttributes().isEmpty()) {
            for (Map.Entry<String, String> attribute : block.getAttributes().entrySet()) {
                builder.append(" ");
                String key = attribute.getKey();
                String value = attribute.getValue();
                builder.append(key).append("=");
                builder.append("\"")
                        .append(value)
                        .append("\"");
            }
        }

        builder.append(">");
        builder.append("\n");

        depth++;

        for (GenericItem item : block.getItems()) {
            item.accept(this);
        }

        depth--;

        builder.append(prefix);
        builder.append("</").append(block.getTag()).append(">");
        builder.append("\n");
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
