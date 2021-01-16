package dev.hbeck.kdl.search.predicates;

import dev.hbeck.kdl.objects.KDLNode;

import java.util.function.Predicate;

public class NodePredicate implements Predicate<KDLNode> {
    private final Predicate<String> identifierPredicate;
    private final NodeContentPredicate contentPredicate;

    public NodePredicate(Predicate<String> identifierPredicate, NodeContentPredicate contentPredicate) {
        this.identifierPredicate = identifierPredicate;
        this.contentPredicate = contentPredicate;
    }

    @Override
    public boolean test(KDLNode node) {
        return identifierPredicate.test(node.getIdentifier()) && contentPredicate.test(node);
    }

    public static NodePredicate any() {
        return new NodePredicate(id -> true, node -> true);
    }
}
