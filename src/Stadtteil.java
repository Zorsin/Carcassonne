/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Stadtteil extends Landschaftsteil {
    boolean wappen = false;
    HimmelsrichtungT[] offeneKanten;
    Stadt stadt;

    public Stadtteil(boolean wappen, HimmelsrichtungT[] offeneKanten) {
        this.wappen = wappen;
        this.offeneKanten = offeneKanten;
        stadt = new Stadt(this);
    }

    @Override
    public int getWert() {
        if(wappen){
            return 2;
        }
        return super.getWert();
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }

    public HimmelsrichtungT[] getOffeneKanten() {
        return offeneKanten;
    }
}
