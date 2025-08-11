import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (!hasPeeked) {
            if (!iterator.hasNext())
                throw new NoSuchElementException();
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    @Override
    public Integer next() {
        if (!hasPeeked)
            return iterator.next();
        Integer result = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}
