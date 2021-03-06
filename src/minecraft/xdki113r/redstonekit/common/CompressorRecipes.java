package xdki113r.redstonekit.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CompressorRecipes
{
    private static final CompressorRecipes smeltingBase = new CompressorRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map<Integer, Integer> amountList = new HashMap<Integer, Integer>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Integer> metaAmount = new HashMap<List<Integer>, Integer>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final CompressorRecipes smelting()
    {
        return smeltingBase;
    }

    private CompressorRecipes()
    {
        this.addSmelting(Block.blockRedstone.blockID, new ItemStack(RedstoneKit.utilityItem, 1, 1), 9);
        this.addSmelting(RedstoneKit.redstoneGlass.blockID, new ItemStack(RedstoneKit.utilityItem, 1, 4), 6);
        this.addSmelting(RedstoneKit.utilityItem.itemID, 1, new ItemStack(RedstoneKit.utilityItem, 1, 3), 9);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack, int par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.amountList.put(par1, par3);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public int getAmount(int par1)
    {
        return this.amountList.containsKey(par1) ? ((Integer)this.amountList.get(par1)).intValue() : 0;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, int experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaAmount.put(Arrays.asList(itemID, metadata), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    public int getAmount(ItemStack item)
    {
    	if (item == null || item.getItem() == null)
        {
            return 0;
        }
        int ret = -1;
        if (ret < 0 && metaAmount.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaAmount.get(Arrays.asList(item.itemID, item.getItemDamage())).intValue();
        }
        if (ret < 0 && amountList.containsKey(item.itemID))
        {
            ret = (amountList.get(item.itemID)).intValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}
