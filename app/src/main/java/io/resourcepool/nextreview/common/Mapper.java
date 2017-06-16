package io.resourcepool.nextreview.common;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 12/06/2017
 */
public interface Mapper<T, U> {
  
  default T from (U o) {
    throw new UnsupportedOperationException();
  }
  default U to (T o) {
    throw new UnsupportedOperationException();
  }
  
  default List<T> from (List<U> os) {
    if (os == null || os.isEmpty()) {
      return null;
    }
    List<T> r = new ArrayList<T>(os.size());
    for (U o : os) {
      r.add(from(o));
    }
    return r;
  }

  default List<U> to(List<T> os) {
    if (os == null || os.isEmpty()) {
      return null;
    }
    List<U> r = new ArrayList<U>(os.size());
    for (T o : os) {
      r.add(to(o));
    }
    return r;
  }
  
}
