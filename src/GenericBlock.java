import java.util.ArrayList;
import java.util.List;

public class GenericBlock extends GenericItem {
    private final List<GenericItem> items = new ArrayList<GenericItem>();

    public GenericBlock(String tag) {
        super(tag);
    }
    
    public static GenericBlock error() {
    	GenericBlock block = new GenericBlock("");
    	block.setIsError(true);
    	return block;
    }

    public void addItem(GenericItem item) {
        items.add(item);
    }

    public List<GenericItem> getItems(String tag) {
        return items.stream()
                .filter(item -> tag.equals(item.getTag()))
                .toList();
    }

    public GenericItem getFirstItem(String tag) {
        GenericItem errorItem = new GenericItem(tag);
        errorItem.setIsError(true);
        return items.stream()
                .filter(item -> tag.equals(item.getTag()))
                .findFirst()
                .orElse(errorItem);
    }

    public GenericBlock getFirstBlock(String tag) {
        GenericBlock errorBlock = new GenericBlock(tag);
        errorBlock.setIsError(true);
        return items.stream()
                .filter(item -> tag.equals(item.getTag()) && (item instanceof GenericBlock))
                .map(item -> (GenericBlock) item)
                .findFirst()
                .orElse(errorBlock);
    }

    public List<GenericItem> getItems() {
        return this.items;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    @Override
    public String toString() {
        return "GenericBlock [tag = " + getTag() + "]";
    }
}
