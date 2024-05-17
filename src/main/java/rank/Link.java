package rank;

import java.util.Objects;

public class Link {
    private String origin;
    private String linked;

    public Link(String o, String l){
        if(o.isEmpty()||l.isEmpty()){
            throw new IllegalArgumentException("Los strings no pueden estar vacios");
        }else{
            this.linked=l;
            this.origin=o;
        }
    }

    public String getLinked() {
        return linked;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return this.origin.equalsIgnoreCase(link.origin)&&this.linked.equalsIgnoreCase(link.linked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, linked);
    }

    @Override
    public String toString() {
        return this.origin+"->"+this.linked;
    }
}
