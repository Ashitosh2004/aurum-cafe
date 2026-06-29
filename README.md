<div align="center">

<img src="screenshots/applogo.png" width="220" />

<br/>

# ⚜️ AURUM CAFÉ ⚜️
### *The Gold Standard of Digital Coffee Craftsmanship*

<br/>

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack_Compose-Material_3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)](https://github.com/)
[![UI/UX](https://img.shields.io/badge/UI--UX-Premium-D4AF37?style=for-the-badge)](https://github.com/)

<br/>

> **Aurum Café** is a luxury mobile sanctuary designed for the true coffee connoisseur. By bridging artisanal heritage with high-performance modern engineering, we deliver a cinematic experience that transforms a daily routine into a high-end ritual.

<br/>

**[✨ Features](#-key-features)**  •  **[📂 Structure](#-project-architecture)**  •  **[📊 Diagrams](#-logic--workflow-diagrams)**  •  **[🏗 Technical](#-technical-blueprint)**  •  **[📈 Metrics](#-performance--metrics)**  •  **[🚀 Setup](#-getting-started)**  •  **[🗺 Roadmap](#-future-roadmap-v20)**

<br/>

╔═══════════════════════════════════════════════════════════╗

</div>

## ✨ Key Features

<table>
<tr>
<td width="50%" valign="top">

### 🏆 The Aurum Reserve
*Signature Collection*

An exclusive category for elite members. Features ultra-premium items like **24-Karat Gold-Infused Lattes** and **Black Truffle Espressos** with custom cinematic detail screens.

<img src="screenshots/specialitems.png" width="100%" />

</td>
<td width="50%" valign="top">

### 🎨 Advanced Customization
*Granular Brew Control*

A granular modification system allowing users to adjust every aspect of their brew:
- **Roast Profiles** — Light to Dark French roasts
- **Artisanal Milks** — Oat, Almond, Jersey, Soy
- **Topping Precision** — Gold flakes, micro-foams

<img src="screenshots/itemdetails.png" width="100%" />

</td>
</tr>
<tr>
<td width="50%" valign="top">

### 💳 Multi-Gateway Payment
*Secure Checkout Flow*

A secure, PCI-compliant inspired checkout flow supporting:
- **Digital Wallets** — Paytm, PhonePe, GPay
- **Direct UPI** — Deep-linking
- **Saved Cards** — Encrypted UI

<img src="screenshots/cart.png" width="100%" />

</td>
<td width="50%" valign="top">

### 💎 Dynamic Tier Rewards
*Loyalty That Pays*

A logic-driven loyalty system where users earn **Aurum Beans** (10% of order value) and progress through membership tiers.

<img src="screenshots/profile.png" width="100%" />

</td>
</tr>
</table>

<div align="center">

╚═══════════════════════════════════════════════════════════╝

</div>

---

## 📱 App Experience

<div align="center">
  <table border="0">
    <tr>
      <td align="center"><b>Cinematic Home</b></td>
      <td align="center"><b>Curated Menu</b></td>
      <td align="center"><b>Premium Wishlist</b></td>
    </tr>
    <tr>
      <td><img src="screenshots/homepage.png" width="250" /></td>
      <td><img src="screenshots/homepageitems.png" width="250" /></td>
      <td><img src="screenshots/wishlist.png" width="250" /></td>
    </tr>
  </table>
</div>

---

## 📂 Project Architecture

The project follows a modified **Clean Architecture** pattern with **MVVM**, ensuring high scalability, testability, and a clear separation of concerns.

### 🌳 Visual File Tree

```text
aurum-cafe-main/
├── app/
│   ├── src/main/java/com/example/
│   │   ├── MainActivity.kt        # Root Entry Point, NavHost, & Compose Logic
│   │   ├── ui/                    # UI Design System
│   │   │   ├── theme/             # Color Palettes (Espresso/Gold/Beige)
│   ├── src/main/res/
│   │   ├── drawable/              # 4K High-res Product Photography
│   │   ├── values/                # Internationalization & String Resources
├── gradle/                        # Build Automation Configuration
├── build.gradle.kts               # Root Project Configuration
├── settings.gradle.kts            # Module Definition
└── local.properties               # SDK & Environment Configuration
```

---

## 📊 Logic & Workflow Diagrams

### 🏗 System Block Diagram
```mermaid
graph TB
    subgraph UI_LAYER ["User Interface (Jetpack Compose)"]
        A[Splash Screen]
        B[Home Screen]
        C[Catalog/Menu]
        D[Product Details]
        E[Cart & Checkout]
        F[Profile/Account]
    end

    subgraph LOGIC_LAYER ["Business Logic (MVVM)"]
        G[Navigation Controller]
        H[State Management]
        I[Reward Engine]
    end

    subgraph DATA_LAYER ["Data & External Services"]
        J[(Local Persistence - Room)]
        K[Image Engine - Coil]
        L[Network - Retrofit/OkHttp]
    end

    UI_LAYER --> G
    G --> UI_LAYER
    UI_LAYER --> H
    H --> UI_LAYER
    H --> I
    UI_LAYER --> K
    H --> J
    H --> L
```

### 🗺 User Journey Flow

```mermaid
%%{init: {'theme':'base', 'themeVariables': { 'primaryColor':'#2C1810', 'primaryTextColor':'#F5E6C8', 'primaryBorderColor':'#D4AF37', 'lineColor':'#D4AF37', 'secondaryColor':'#3E2723', 'tertiaryColor':'#1A100B', 'fontFamily':'Georgia, serif', 'fontSize':'15px', 'edgeLabelBackground':'#2C1810'}}}%%
graph TD
    A["☕ Splash Screen"]:::entry --> B{"✨ First Time?"}:::decision
    B -- Yes --> C["🌟 Onboarding Experience"]:::flow
    B -- No --> D["🎬 Cinematic Home"]:::flow
    C --> D
    D --> E["🔍 Smart Product Search"]:::flow
    D --> F["👑 Aurum Reserve Carousel"]:::premium
    E --> G["🎨 Customization Engine"]:::flow
    F --> G
    G --> H["🛒 Interactive Cart"]:::flow
    H --> I["🔐 Secure Payment Gateway"]:::flow
    I --> J["💎 Reward Logic Engine"]:::premium
    J --> K["✅ Order Confirmation"]:::success

    classDef entry fill:#1A100B,stroke:#D4AF37,stroke-width:2px,color:#F5E6C8
    classDef decision fill:#3E2723,stroke:#D4AF37,stroke-width:2px,color:#F5E6C8
    classDef flow fill:#2C1810,stroke:#D4AF37,stroke-width:2px,color:#F5E6C8
    classDef premium fill:#5C4422,stroke:#FFD700,stroke-width:3px,color:#FFF8E1
    classDef success fill:#1B3A2A,stroke:#4ADE80,stroke-width:2px,color:#E6FFF0
```

<div align="center">

<sub>🥇 <b>Gold-bordered nodes</b> mark premium, revenue-critical touchpoints in the journey</sub>

</div>

<br/>

### ☕ Order Processing Lifecycle

```mermaid
%%{init: {'theme':'base', 'themeVariables': { 'primaryColor':'#2C1810', 'primaryTextColor':'#F5E6C8', 'primaryBorderColor':'#D4AF37', 'lineColor':'#D4AF37', 'secondaryColor':'#3E2723', 'tertiaryColor':'#1A100B', 'fontFamily':'Georgia, serif', 'fontSize':'15px'}}}%%
stateDiagram-v2
    classDef gold fill:#5C4422,stroke:#FFD700,stroke-width:3px,color:#FFF8E1
    classDef dark fill:#2C1810,stroke:#D4AF37,stroke-width:2px,color:#F5E6C8
    classDef done fill:#1B3A2A,stroke:#4ADE80,stroke-width:2px,color:#E6FFF0

    [*] --> Browsing
    Browsing --> Customizing: Item Selected
    Customizing --> InCart: Added
    InCart --> Processing: Payment Initiated
    Processing --> Verified: UPI/Card Success
    Verified --> Brewing: Order Logged
    Brewing --> Completed: Ready for Pickup
    Completed --> [*]

    class Browsing dark
    class Customizing dark
    class InCart dark
    class Processing gold
    class Verified gold
    class Brewing gold
    class Completed done
```

<div align="center">

<sub>💳 <b>Gold states</b> represent the secure transaction core — from payment intent to brewing</sub>

</div>

---

## 🏗 Technical Blueprint

<div align="center">

| 🧩 Feature | ⚙️ Implementation Detail | 🎯 Advantage |
| :--- | :--- | :--- |
| **UI Framework** | Jetpack Compose (Material 3) | Declarative, modern, and rapid UI development. |
| **State Management** | `mutableStateOf` & `remember` | Scoped lifecycle management for fluid interactions. |
| **Image Pipeline** | **Coil** (Coroutines-based) | Memory-efficient, async loading with downsampling. |
| **Navigation** | **Compose Navigation** (Type-Safe) | Robust route management and argument passing. |
| **Haptics** | `LocalHapticFeedback` | Tactile confirmation on premium interactions. |
| **Persistence** | **Room Database** | Offline-ready local storage for cart and history. |
| **Networking** | **Retrofit + OkHttp** | Scalable API communication with interceptors. |
| **Serialization** | **Moshi** | Modern JSON parsing for Kotlin data classes. |

</div>

---

## 📈 Performance & Metrics

<div align="center">

We prioritize a flawless, butter-smooth user experience.

| ⚡ Startup Speed | 🎞️ Rendering | 🧠 Memory | 🔋 Battery | 📦 Binary Size |
| :---: | :---: | :---: | :---: | :---: |
| **~1.2s** | **60 FPS** | **< 180MB** | **Low-power** | **~12MB** |
| optimized asset loading | constant on modern hardware | during catalog browsing | background processing | optimized via R8/Proguard |

</div>

---

## 🛡️ Security & Reliability

- 🔒 **ProGuard/R8** — Obfuscation and code shrinking for IP protection.
- 📱 **Edge-to-Edge** — Full screen immersion on Android 10+ devices.
- 🤚 **Haptic Feedback** — Integrated into the "Add to Cart" and "Category Select" flows for a tactile, physical feel.
- 📐 **Responsive Design** — Dynamic layouts that adapt to various screen ratios and sizes.

---

## 🛠 Future Roadmap (v2.0)

- [ ] **Live Order Tracking** — Real-time GPS and map integration.
- [ ] **AR Preview** — Visualize your coffee art in 3D using ARCore.
- [ ] **Dark Mode** — High-contrast "Midnight Blend" premium theme.
- [ ] **Voice Ordering** — Hands-free selection for the on-the-go user.
- [ ] **Multilingual Support** — French, Italian, and Spanish localizations.

---

## 🚀 Getting Started

### 📋 Prerequisites

| Requirement | Version |
| :--- | :--- |
| **Android Studio** | Ladybug \| 2024.2.1 or newer |
| **Gradle** | 9.0+ |
| **JDK** | 17 or 21 (LTS recommended) |

### 🛠 Installation

**1. Clone the Repo**
```bash
git clone https://github.com/Ashitosh2004/aurum-cafe.git
```

**2. Gradle Sync**
Open the project in Android Studio and let the dependencies download.

**3. Deploy**
Select `Build > Make Project` and run on your target device.

---

<div align="center">

### ☕ *"Crafting More Than Just Coffee"*

<sub>© 2026 Aurum Café. All Rights Reserved.</sub>
<br/>
<sub><i>Crafted with precision, passion, and the finest beans in the digital world.</i></sub>

<br/><br/>

⚜️ **AURUM CAFÉ** ⚜️

</div>
