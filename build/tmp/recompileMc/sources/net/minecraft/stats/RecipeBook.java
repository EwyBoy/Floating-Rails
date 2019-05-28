package net.minecraft.stats;

import java.util.BitSet;
import javax.annotation.Nullable;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RecipeBook
{
    protected final BitSet recipes = new BitSet();
    /** Recipes the player has not yet seen, so the GUI can play an animation */
    protected final BitSet unseenRecipes = new BitSet();
    protected boolean isGuiOpen;
    protected boolean isFilteringCraftable;

    public void apply(RecipeBook that)
    {
        this.recipes.clear();
        this.unseenRecipes.clear();
        this.recipes.or(that.recipes);
        this.unseenRecipes.or(that.unseenRecipes);
    }

    public void setRecipes(IRecipe recipe)
    {
        if (!recipe.isHidden())
        {
            this.recipes.set(getRecipeId(recipe));
        }
    }

    public boolean containsRecipe(@Nullable IRecipe recipe)
    {
        return this.recipes.get(getRecipeId(recipe));
    }

    public void removeRecipe(IRecipe recipe)
    {
        int i = getRecipeId(recipe);
        this.recipes.clear(i);
        this.unseenRecipes.clear(i);
    }

    @Deprecated //DO NOT USE
    protected static int getRecipeId(@Nullable IRecipe recipe)
    {
        int ret = CraftingManager.REGISTRY.getIDForObject(recipe);
        if (ret == -1)
        {
            ret = ((net.minecraftforge.registries.ForgeRegistry<IRecipe>)net.minecraftforge.fml.common.registry.ForgeRegistries.RECIPES).getID(recipe.getRegistryName());
            if (ret == -1)
                throw new IllegalArgumentException(String.format("Attempted to get the ID for a unknown recipe: %s Name: %s", recipe, recipe.getRegistryName()));
        }
        return ret;
    }

    @SideOnly(Side.CLIENT)
    public boolean isRecipeUnseen(IRecipe recipe)
    {
        return this.unseenRecipes.get(getRecipeId(recipe));
    }

    public void setRecipeSeen(IRecipe recipe)
    {
        this.unseenRecipes.clear(getRecipeId(recipe));
    }

    public void addDisplayedRecipe(IRecipe recipe)
    {
        this.unseenRecipes.set(getRecipeId(recipe));
    }

    @SideOnly(Side.CLIENT)
    public boolean isGuiOpen()
    {
        return this.isGuiOpen;
    }

    public void setGuiOpen(boolean p_192813_1_)
    {
        this.isGuiOpen = p_192813_1_;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFilteringCraftable()
    {
        return this.isFilteringCraftable;
    }

    public void setFilteringCraftable(boolean p_192810_1_)
    {
        this.isFilteringCraftable = p_192810_1_;
    }
}