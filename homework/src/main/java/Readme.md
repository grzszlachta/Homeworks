## HomeWork 8

By the templates testReflexiveEquals and testEqualsNull in ClientTest complete test package for [Objects#equals](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object)) rules: 

The equals method implements an equivalence relation on non-null object references:

- It is reflexive: for any non-null reference value x, x.equals(x) should return true.
- For any non-null reference value x, x.equals(null) should return false.
- It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
- It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
- It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.

Please, see [link](https://www.tutorialspoint.com/junit/junit_using_assertion.htm) for Assert.assertTrue and Assert.assertFalse