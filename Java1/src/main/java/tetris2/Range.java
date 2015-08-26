package tetris2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umesh on 8/25/15.
 */
public class Range {
    int x;
    int size;
    int height;

    public int getY() {
        return x + size;
    }

    List<Range> intersect(Range other) {
        List<Range> list = new ArrayList<Range>();
        if(other.x < this.x && other.getY() > this.getY()) {
            //This range will be removed.
            return new ArrayList<Range>();
        }
        if(other.x > this.x && other.getY() < this.getY()) {
            List result = new ArrayList<Range>();
            Range r1 =  new Range();
            r1.x = this.x;
            r1.size = (other.x - this.x);
            r1.height = this.height;
            result.add(r1);
            Range r2 =  new Range();
            r2.x = this.x + other.size;
            r2.size = (this.getY() - other.getY());
            r2.height = this.height;
            result.add(r2);

            if(other.height < this.height) {
                other.height = this.height;
            }
            return result;
        }
        if(other.getY() < this.x || other.x > this.getY()) {
            List result = new ArrayList<Range>();
            result.add(this);
            return result;
        }
        if(this.x < other.x && this.getY() > other.x) {
            List result = new ArrayList<Range>();
            Range r1 =  new Range();
            r1.x = this.x;
            r1.size = (other.x - this.x);
            r1.height = this.height;
            result.add(r1);

            if(other.height < this.height) {
                other.height = this.height;
            }
            return result;
        }
        if(this.x > other.x && this.getY() > other.x) {
            List result = new ArrayList<Range>();
            Range r2 =  new Range();
            r2.x = other.getY();
            r2.size = (this.getY() - other.getY());
            r2.height = this.height;
            result.add(r2);

            if(other.height < this.height) {
                other.height = this.height;
            }

            return result;
        }

        return list;

    }

    @Override
    public String toString() {
        return "Range{" +
                "x=" + x +
                ", size=" + size +
                ", height=" + height +
                '}';
    }
    /*
    public String toString() {
        return x + "," + size + "," + height;
    }
    */
}
