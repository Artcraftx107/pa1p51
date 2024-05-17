package rank;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Web {
    private Set<Link> links;
    protected Set<Site> sites;
    private double THRESHOLD;
    private Random alea;

    public Web(){
        this.links=new HashSet<>();
        this.sites=new HashSet<>();
    }

    protected void addSite(Site site){
        sites.add(site);
    }

    protected void addSiteWithName(String n){
        Site site = new Site(n);
        sites.add(site);
    }

    public void addLink(String dataLink){
        String[] data = dataLink.split("->");
        String name = data[0];
        String bruh = data[1];
        if(name.isEmpty()||bruh.isEmpty()){
            throw new IllegalArgumentException("El dataLink especificado ("+dataLink+") ha dado un fallo a la hora de dividirlo en partes");
        }else{
            Link xd = new Link(name, bruh);
            addSiteWithName(name);
            addSiteWithName(bruh);
            links.add(xd);
        }
    }

    public Site getSite(String name){

    }
}
