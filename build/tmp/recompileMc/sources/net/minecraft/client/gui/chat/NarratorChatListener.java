package net.minecraft.client.gui.chat;

import com.mojang.text2speech.Narrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.SystemToast;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NarratorChatListener implements IChatListener
{
    public static final NarratorChatListener INSTANCE = new NarratorChatListener();
    private final Narrator narrator = Narrator.getNarrator();

    public void say(ChatType p_192576_1_, ITextComponent p_192576_2_)
    {
        int i = Minecraft.getMinecraft().gameSettings.narrator;

        if (i != 0 && this.narrator.active())
        {
            if (i == 1 || i == 2 && p_192576_1_ == ChatType.CHAT || i == 3 && p_192576_1_ == ChatType.SYSTEM)
            {
                if (p_192576_2_ instanceof TextComponentTranslation && "chat.type.text".equals(((TextComponentTranslation)p_192576_2_).getKey()))
                {
                    this.narrator.say((new TextComponentTranslation("chat.type.text.narrate", ((TextComponentTranslation)p_192576_2_).getFormatArgs())).getUnformattedText());
                }
                else
                {
                    this.narrator.say(p_192576_2_.getUnformattedText());
                }
            }
        }
    }

    public void announceMode(int p_193641_1_)
    {
        this.narrator.clear();
        this.narrator.say((new TextComponentTranslation("options.narrator", new Object[0])).getUnformattedText() + " : " + (new TextComponentTranslation(GameSettings.NARRATOR_MODES[p_193641_1_], new Object[0])).getUnformattedText());
        GuiToast guitoast = Minecraft.getMinecraft().getToastGui();

        if (this.narrator.active())
        {
            if (p_193641_1_ == 0)
            {
                SystemToast.addOrUpdate(guitoast, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), (ITextComponent)null);
            }
            else
            {
                SystemToast.addOrUpdate(guitoast, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.enabled", new Object[0]), new TextComponentTranslation(GameSettings.NARRATOR_MODES[p_193641_1_], new Object[0]));
            }
        }
        else
        {
            SystemToast.addOrUpdate(guitoast, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), new TextComponentTranslation("options.narrator.notavailable", new Object[0]));
        }
    }

    public boolean isActive()
    {
        return this.narrator.active();
    }

    public void clear()
    {
        this.narrator.clear();
    }
}