import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {
    private List<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null || Arrays.asList(points).contains(null)) throw new NullPointerException();
        Point[] copy = points.clone();
        Comparator<Point> pointComparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.compareTo(o2) == 0) throw new IllegalArgumentException();
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(copy, pointComparator);

        for (int i = 0; i < copy.length - 3; i++) {
            Arrays.sort(copy, pointComparator);
            Arrays.sort(copy, copy[i].slopeOrder());
            for (int p = 0, start = 1, end = 2; end < copy.length; end++) {
                while (end < copy.length && copy[p].slopeTo(copy[start]) == copy[p].slopeTo(copy[end])) end++;
                if (end - start >= 3 && copy[p].compareTo(copy[start]) < 0) {
                    segments.add(new LineSegment(copy[p], copy[end - 1]));
                }
                start = end;
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[numberOfSegments()]);
    }

    public static void main(String[] args) {
        // read the N points from a file
        In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }
}