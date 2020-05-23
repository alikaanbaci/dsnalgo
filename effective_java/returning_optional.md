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

if you return null or throw an unchecked exception client might not handle these cases.  and if you trhow an checked exception, tihs adds to boilerplate code.

("boilerplate code" is any seemingly repetitive code that shows up again and again in order to get some result that seems like it ought to be much simpler)

if your methor returns an optionaş you can take any actions:

```java
// Using an optional to provide a chosen default value
String lastWordInLexicon = max(words).orElse("No words...");

// Using an optional to throw a chosen exception
Toy myToy = max(toys).orElseThrow(TemperTantrumException::new);

// Using optional when you know there’s a return value
Element lastNobleGas = max(Elements.NOBLE_GASES).get();
```

In summary, if you find yourself writing a method that can’t always return a value and you believe it is important that users of the method consider this possibility every time they call it, then you should probably return an optional.

You should, however, be aware that there are real performance consequences  associated with returning optionals; for performance-critical methods, it may be better to return a null or throw an exception. Finally, you should rarely use an optional in any other capacity than as a return value.







