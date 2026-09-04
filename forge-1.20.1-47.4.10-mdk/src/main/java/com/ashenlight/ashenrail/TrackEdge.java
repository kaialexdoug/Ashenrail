package com.ashenlight.ashenrail;

public class TrackEdge {
    public double length;

    public TrackNode nodeA;
    public TrackNode nodeB;

    public TrackEdge(TrackNode nodeA, TrackNode nodeB) {
        this.length = nodeA.position.distanceTo(nodeB.position);

        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }
}
