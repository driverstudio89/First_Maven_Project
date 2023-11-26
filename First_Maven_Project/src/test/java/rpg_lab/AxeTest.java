package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        int expectedDurability = AXE_DURABILITY - 1;
        axe.attack(dummy);
        assertEquals(expectedDurability, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        axe.attack(dummy);
        axe.attack(dummy);
    }

}
