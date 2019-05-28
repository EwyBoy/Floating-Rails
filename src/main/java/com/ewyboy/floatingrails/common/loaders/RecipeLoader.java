package com.ewyboy.floatingrails.common.loaders;

import com.ewyboy.floatingrails.common.Register;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static com.ewyboy.bibliotheca.common.loaders.RecipeLoader.addShapelessRecipe;

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
}
