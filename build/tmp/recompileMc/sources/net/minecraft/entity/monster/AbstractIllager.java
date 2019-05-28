package net.minecraft.entity.monster;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbstractIllager extends EntityMob
{
    protected static final DataParameter<Byte> AGGRESSIVE = EntityDataManager.<Byte>createKey(AbstractIllager.class, DataSerializers.BYTE);

    public AbstractIllager(World p_i47509_1_)
    {
        super(p_i47509_1_);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(AGGRESSIVE, Byte.valueOf((byte)0));
    }

    @SideOnly(Side.CLIENT)
    protected boolean isAggressive(int p_193078_1_)
    {
        int i = ((Byte)this.dataManager.get(AGGRESSIVE)).byteValue();
        return (i & p_193078_1_) != 0;
    }

    protected void setAggressive(int p_193079_1_, boolean p_193079_2_)
    {
        int i = ((Byte)this.dataManager.get(AGGRESSIVE)).byteValue();

        if (p_193079_2_)
        {
            i = i | p_193079_1_;
        }
        else
        {
            i = i & ~p_193079_1_;
        }

        this.dataManager.set(AGGRESSIVE, Byte.valueOf((byte)(i & 255)));
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ILLAGER;
    }

    @SideOnly(Side.CLIENT)
    public AbstractIllager.IllagerArmPose getArmPose()
    {
        return AbstractIllager.IllagerArmPose.CROSSED;
    }

    @SideOnly(Side.CLIENT)
    public static enum IllagerArmPose
    {
        CROSSED,
        ATTACKING,
        SPELLCASTING,
        BOW_AND_ARROW;
    }
}