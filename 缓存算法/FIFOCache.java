import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
  // 最大容量
  private final int maximumSize;

  public FIFOCache(final int maximumSize) {
    // true 代表按访问顺序排序，false 代表按插入顺序排序
    super(maximumSize, 0.75f, false);
    this.maximumSize = maximumSize;
  }

  // 当元素大于最大容量时，就删除最旧的元素
  @Override
  protected boolean removeEldestEntry(final Map.Entry eldest) {
    return size() > maximumSize;
  }
}