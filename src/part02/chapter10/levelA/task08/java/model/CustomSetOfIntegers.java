package part02.chapter10.levelA.task08.java.model;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomSetOfIntegers implements Set<Integer> {

    private List<Integer> elements = new ArrayList<>();

    public CustomSetOfIntegers(Integer... elements) {
        for (Integer element : elements) {
            add(element);
        }
    }

    public CustomSetOfIntegers(Collection<Integer> collection) {
        for (Integer element : collection) {
            add(element);
        }
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return elements.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        if (!elements.contains(integer)) {
            return elements.add(integer);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Integer> c) {
        boolean wasModified = false;
        for (Integer integer : c) {
            if (add(integer)) {
                wasModified = true;
            }
        }
        return wasModified;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    public CustomSetOfIntegers obtainIntersect(CustomSetOfIntegers other) {
        CustomSetOfIntegers result = new CustomSetOfIntegers();
        for (Integer element : elements) {
            if (other.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public CustomSetOfIntegers unifyToOther(CustomSetOfIntegers other) {
        CustomSetOfIntegers result = new CustomSetOfIntegers(new ArrayList<>(elements));
        result.addAll(other);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName() + "{");
        for (int i = 0; i < elements.size(); i++) {
            stringBuilder.append(elements.get(i));
            if (i != elements.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}