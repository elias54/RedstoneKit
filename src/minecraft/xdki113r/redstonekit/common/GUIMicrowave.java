package xdki113r.redstonekit.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GUIMicrowave extends GuiContainer
{
    private static final ResourceLocation field_110410_t = new ResourceLocation("textures/gui/container/furnace.png");
    private TileEntityMicrowave microwaveInventory;

    public GUIMicrowave(InventoryPlayer par1InventoryPlayer, TileEntityMicrowave par2TileEntityMicrowave)
    {
        super(new ContainerMicrowave(par1InventoryPlayer, par2TileEntityMicrowave));
        this.microwaveInventory = par2TileEntityMicrowave;
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.microwaveInventory.isInvNameLocalized() ? this.microwaveInventory.getInvName() : I18n.func_135053_a(this.microwaveInventory.getInvName());
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.func_135053_a("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.func_110434_K().func_110577_a(field_110410_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.microwaveInventory.isBurning())
        {
            i1 = this.microwaveInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.microwaveInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}