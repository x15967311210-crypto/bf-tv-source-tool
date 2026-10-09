# 暴风电视 · 信号源小工具 (bfsig)

给"新桌面（Simple TV Launcher）"补一个 **HDMI / 信号源** 入口的极简安卓工具。

安装后打开，三个按钮：

- ① 打开 HDMI / 电视画面 → `com.baofengtv.tvplayer`
- ② 信号源切换（风UI） → `com.baofengtv.launcher3d`
- ③ 系统设置 → `com.baofengtv.settings`

## 构建

推送到 GitHub 后由 GitHub Actions 自动构建：Actions 运行完成后，在运行的详情页下载工件 `bfsig-apk`（里面是 `app-debug.apk`）。

本地构建（需 Android SDK + JDK17）：

```bash
gradle assembleDebug
```
