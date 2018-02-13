package com.ewyboy.floatingrails.common.loaders;

import com.ewyboy.floatingrails.common.Register;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.registries.GameData;

/**
 * Created by EwyBoy
 */
public class RecipeLoader {

    //Nothing to see here
    public static void loadRecipes() {
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,1), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,2), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,3), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,4), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,5), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,6), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,7), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail,8), new ItemStack(Blocks.WATERLILY), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));

        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,1), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,2), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,3), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,4), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,5), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,6), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,7), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
        addShapelessRecipe(new ItemStack(Register.Blocks.floatingRail_Lava,8), new ItemStack(Register.Blocks.magmalily),  new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL), new ItemStack(Blocks.RAIL));
    }

    //TODO MOve this into biblib

    public static void addShapelessRecipe(ItemStack output, Object... input) {
        ResourceLocation location = getNameForRecipe(output);
        ShapelessRecipes recipe = new ShapelessRecipes(location.getResourceDomain(), output, buildInput(input));
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    private static NonNullList<Ingredient> buildInput(Object[] input) {
        NonNullList<Ingredient> list = NonNullList.create();
        for (Object obj : input) {
            if (obj instanceof Ingredient) {
                list.add((Ingredient) obj);
            } else {
                Ingredient ingredient = CraftingHelper.getIngredient(obj);
                if (ingredient == null) {
                    ingredient = Ingredient.EMPTY;
                }
                list.add(ingredient);
            }
        }
        return list;
    }

    public static ResourceLocation getNameForRecipe(ItemStack output) {
        ModContainer activeContainer = Loader.instance().activeModContainer();
        ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
        ResourceLocation recipeLoc = baseLoc;
        int index = 0;
        while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
            index++;
            recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
        }
        return recipeLoc;
    }


}
