package petmongrels.sdb.utility.spring;

public class TestBeanForConventionBasedContextBuilder {
    TestDependeeBeanForConventionBasedContextBuilder childBean;

    public TestBeanForConventionBasedContextBuilder(TestDependeeBeanForConventionBasedContextBuilder childBean) {
        this.childBean = childBean;
    }
}
