package link.infra.mixintrace.mixin;

import link.infra.mixintrace.TraceUtils;
import net.modificationstation.stationapi.api.util.crash.CrashReportSection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CrashReportSection.class)
public abstract class MixinCrashReportSection {
    @Shadow(remap = false) private StackTraceElement[] stackTrace;

    @Inject(method = "addStackTrace", at = @At("TAIL"), remap=false)
    private void mixintrace_addTrace(StringBuilder crashReportBuilder, CallbackInfo ci) {
        TraceUtils.printTrace(stackTrace, crashReportBuilder);
    }
}