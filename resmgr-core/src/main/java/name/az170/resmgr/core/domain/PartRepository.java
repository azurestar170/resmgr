package name.az170.resmgr.core.domain;

public class PartRepository extends DomainBase {

    private String partId;
    private String repositoryId;

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

}
