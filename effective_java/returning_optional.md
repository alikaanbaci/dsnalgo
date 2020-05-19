## Returning Optional

If your method unable return a value under certain circumstances, you have two option

1. **Returning null** (If a method return null, clients must handle this case, if don't then NullPointerException will be thrown somewhere
1. **Throwing an exceptions** (Throwing an exception is expensive because the entire stack is captured)

Another option in Java8 is optional. An immutable collection that can hold one element.
A method that conceptually returns a T but may be unable to do so nder certain circumstances can instead be declared to return an Optional<T>. 
This allows the method to return an empty result to indicate that it couldn’t return a valid result. 
An Optional-returning method is more flexible and easier to use than one that throws an exception, and it is less error-prone than one that returns null

Returns maximum value in collection - throws exception if empty
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

// Returns maximum value in collection as an Optional<E>
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

When we should use it?
Optionals force the user of an API to confront the fact that there may be no value returned.
