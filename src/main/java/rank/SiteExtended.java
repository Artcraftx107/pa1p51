package rank;

public class SiteExtended extends Site{
    private boolean valid;

    public SiteExtended(String n){
        super(n);
        this.valid=true;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        String fin;
        if(valid){
            fin=super.toString();
        }else{
            fin=super.toString()+"*";
        }
        return fin;
    }
}
