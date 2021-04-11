package tfar.norespawnscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NoRespawnScreen.MODID)
public class NoRespawnScreen {
    // Directly reference a log4j logger.

    public static final String MODID = "norespawnscreen";

    public NoRespawnScreen() {
        //IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the doClientStuff method for modloading
        if (FMLEnvironment.dist.isClient()) {
            MinecraftForge.EVENT_BUS.addListener(this::guiopenevent);
        }
    }

    public static boolean respawnIsActive = true;
    public void guiopenevent(GuiOpenEvent event) {
        if(event.getGui() instanceof DeathScreen && respawnIsActive) {
            PlayerEntity player = Minecraft.getInstance().player;
            player.respawnPlayer();
        }
    }
}
