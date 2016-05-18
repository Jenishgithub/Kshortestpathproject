

import org.jgrapht.*;


/**
 * Helper class for {@link KShortestPaths}.
 *
 * @author Guillaume Boulmier
 * @since July 5, 2007
 */
final class RankingPathElement<V, E>
    extends AbstractPathElement<V, E>
{
    /**
     * Weight of the path.
     */
    private double weight;

    /**
     * Creates a path element by concatenation of an edge to a path element.
     *
     * @param pathElement
     * @param edge edge reaching the end vertex of the path element created.
     * @param weight total cost of the created path element.
     */
    RankingPathElement(
        Graph<V, E> graph,
        RankingPathElement<V, E> pathElement,
        E edge,
        double weight)
    {
        super(graph, pathElement, edge);
        this.weight = weight;
    }

    /**
     * Creates an empty path element.
     *
     * @param vertex end vertex of the path element.
     */
    RankingPathElement(V vertex)
    {
        super(vertex);
        this.weight = 0;
    }

    /**
     * Returns the weight of the path.
     *
     * @return .
     */
    public double getWeight()
    {
        return this.weight;
    }

    /**
     * Returns the previous path element.
     *
     * @return <code>null</code> is the path is empty.
     */
    @Override public RankingPathElement<V, E> getPrevPathElement()
    {
        return (RankingPathElement<V, E>) super.getPrevPathElement();
    }
}

// End RankingPathElement.java
