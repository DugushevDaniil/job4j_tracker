package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobSortTest {
    @Test
    public void jobAscByNameTest() {
        Comparator<Job> ascName = new JobAscByName();
        int rsl = ascName.compare(
                new Job("Policeman", 10),
                new Job("Manager", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void jobAscByPriorityTest() {
        Comparator<Job> ascPriority = new JobAscByPriority();
        int rsl = ascPriority.compare(
                new Job("Policeman", 10),
                new Job("Manager", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void jobDescByNameTest() {
        Comparator<Job> descName = new JobDescByName();
        int rsl = descName.compare(
                new Job("Policeman", 10),
                new Job("Manager", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void jobDescByPriorityTest() {
        Comparator<Job> descPriority = new JobDescByName();
        int rsl = descPriority.compare(
                new Job("Policeman", 10),
                new Job("Manager", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void jobDescCombineTest() {
        Comparator<Job> descNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = descNamePriority.compare(
                new Job("Policeman", 1),
                new Job("Policeman", 10)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void jobAscCombineTest() {
        Comparator<Job> ascNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = ascNamePriority.compare(
                new Job("Policeman", 1),
                new Job("Policeman", 10)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void jobCombineTest() {
        Comparator<Job> descNameAscPriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = descNameAscPriority.compare(
                new Job("Policeman", 1),
                new Job("Policeman", 10)
        );
        assertThat(rsl).isLessThan(0);
    }
}