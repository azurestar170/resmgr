package name.az170.resmgr.core.domain;

public class Part extends DomainBase {

    private String partGroupId;
    private int partnum;
    private long size;

    public String getPartGroupId() {
        return partGroupId;
    }

    public void setPartGroupId(String partGroupId) {
        this.partGroupId = partGroupId;
    }

    public int getPartnum() {
        return partnum;
    }

    public void setPartnum(int partnum) {
        this.partnum = partnum;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
