package link.infra.mixintrace.mixin;

import link.infra.mixintrace.TraceUtils;
import net.minecraft.class_447;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "method_2126", at = @At("HEAD"))
    public void mixintrace_method_2126(class_447 par1, CallbackInfo ci) {
        StringBuilder crashReportBuilder = new StringBuilder();
        TraceUtils.printTrace(par1.field_1705.getStackTrace(), crashReportBuilder);
        System.out.println(crashReportBuilder);
    }
}
