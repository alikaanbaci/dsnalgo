## Returning Optional

If your method unable return a value under certain circumstances, you have two option

1. **Returning null** (If a method return null, clients must handle this case, if don't then NullPointerException will be thrown somewhere
1. **Throwing an exceptions** (Throwing an exception is expensive because the entire stack is captured)

Another option in Java8 is optional. An immutable collection that can hold one element.

An example code

```java
public static <E extends Comparable<E>> E max(Collection<E> c) {
	if (c.isEmpty())
		throw new IllegalArgumentException("Empty collection");
	E result = null;
	for (E e : c)
		if (result == null || e.compareTo(result) > 0)
			result = Objects.requireNonNull(e);
	return result;
}
```
```java
Optional<E> public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
	if (c.isEmpty())
		return Optional.empty();
	E result = null;
	for (E e : c)
		if (result == null || e.compareTo(result) > 0)
			result = Objects.requireNonNull(e);
	return Optional.of(result);
}
```
