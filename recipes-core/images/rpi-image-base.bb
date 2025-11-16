SUMMARY = "Base image for Raspberry Pi"
DESCRIPTION = "Custom image based on core-image-full-cmdline with platform-specific additions"

LICENSE = "MIT"

inherit core-image

# Start with full command-line base
IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURES += "package-management"
IMAGE_FEATURES += "debug-tweaks"

# Core packages
IMAGE_INSTALL:append = " \
    kernel-modules \
    u-boot-fw-utils \
    dtc \
    i2c-tools \
    spitools \
    mtd-utils \
    can-utils \
    ethtool \
    iperf3 \
    tcpdump \
    strace \
    gdbserver \
    python3 \
    python3-pip \
    git \
    vim \
    htop \
"

# Platform-specific kernel and bootloader
IMAGE_INSTALL:append = " \
    linux-custom \
    u-boot-custom \
    device-tree-rpi \
"

# Additional development tools
IMAGE_INSTALL:append = " \
    cmake \
    make \
    gcc \
    g++ \
"

# Set root password for debugging (remove for production)
# Password: root
EXTRA_USERS_PARAMS = "usermod -P root root;"

COMPATIBLE_MACHINE = "raspberrypi|raspberrypi-armv7|raspberrypi-armv8|raspberrypi-cm|raspberrypi-cm3|raspberrypi0|raspberrypi0-2w|raspberrypi0-2w-64|raspberrypi0-wifi|raspberrypi2|raspberrypi3|raspberrypi3-64|raspberrypi4|raspberrypi4-64|raspberrypi5"
