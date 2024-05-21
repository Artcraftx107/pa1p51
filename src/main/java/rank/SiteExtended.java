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
        String stfu;
        if(valid){
            stfu=super.toString();
        }else{
            stfu=super.toString()+"*";
        }
        return stfu;
    }
}
