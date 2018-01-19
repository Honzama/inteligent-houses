package cz.cvut.fel.omo.inteligenthouses.simulation.event;

/**
 *
 * @author macekja7
 * @param <T>
 */
public abstract class ObjectPool<T> {

    public abstract void add(T t);

    public abstract void remove(T t);
}
