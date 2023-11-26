package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 20;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void takeAttack_Loses_Health_If_Dummy_IsAlive() {
        axe.attack(dummy);
        int expectedHealth = DUMMY_HEALTH - AXE_ATTACK;
        Assert.assertEquals(expectedHealth, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void takeAttack_Throws_IfDead() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);
        axe.attack(dummy);
    }

    @Test
    public void giveExperience_Gives_Experience_If_Dummy_Dead() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);
        int experience = dummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, experience);
    }

    @Test(expected = IllegalStateException.class)
    public void giveExperience_CannotGive_WhenAlive() {
        int experience = dummy.giveExperience();
    }


}
