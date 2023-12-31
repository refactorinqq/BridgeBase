# Bridge Base

An easy-to-use base with base bridging already set up.

[![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by/4.0/)

<b>Before starting off, I highly suggest you read:

[This article](https://refactoringg.medium.com/how-bridges-work-a-tutorial-on-how-to-create-a-bridge-system-for-your-client-9e264342ca9a) by Me and <br>[
This article](https://github.com/Decencies/Articles/wiki/Lunar---Bridge) by Decencies.
</b>

## The Bridge

The Bridge is an inheritance based system which uses Interfaces to allow the client to work on multiple versions with minimal modification. (Decencies 1)

This is how most clients multi version. Our implementation is the same as Lunar's

In our implementation, all the client code is stored in the Client module, which has no access to the Minecraft API.
You have to create your own bridges and use them. In the target versions, you'd implement those bridges to access the Minecraft API.

## Table of Contents

- [Introduction](#bridge-base)
- [How to Create a Bridge](#how-to-create-a-bridge)
    1. [Add Your Bridge](#1-add-your-bridge)
    2. [Define Bridge Methods](#2-define-bridge-methods)
    3. [Implement the Bridge](#3-implement-the-bridge)

## Introduction

Bridge Base is a framework designed to simplify the process of creating bridges for client developers. By providing an easy-to-use base with pre-configured bridging, developers can focus on the core functionality of their projects without dealing with the intricacies of bridging implementation.

## How to Create a Bridge

Creating a bridge with Bridge Base involves a few straightforward steps. Follow this guide to seamlessly integrate your bridge into the framework.

### 1. Add Your Bridge

Begin by adding your bridge to the `bridge` module.

```java
package your.package.bridge;

public interface ExampleBridge {
    // Here is where you would add your bridges
}
```

### 2. Define Bridge Methods

<b>IMPORTANT: </b> Make sure to start your methods with `bridge$` or sometimes they can clash with the existing methods in your target class.

Inside your `ExampleBridge` interface, define the methods that you need. For example:

```java
package your.package.bridge;

public interface ExampleBridge {
    public void bridge$test();
}
```

### 3. Implement the Bridge

To integrate your bridge, implement it either as a mixin or as an implementation in your target versions. Here's a basic example:

```java
package your.package.plugin;

import bridge.your.package.bridge.ExampleBridge;

@Mixin(Example.class)
public abstract class MixinExample implements ExampleBridge {
    public abstract void test();
    
    @Override
    public void bridge$test() {
        test(); // This is the implementation
    }
}
```

By following these steps, you seamlessly integrate your needed bridge into Bridge Base, allowing client developers to leverage its functionality effortlessly.

Feel free to explore the [repository](https://github.com/refactorinqq/BridgeBase) for additional details and updates. 

🔥 Happy bridging, and star if you have found this useful!

### Contributing

Fork, and open a PR. If it's good, I'll merge it. Make sure to give your PRs proper descriptions

### License

<p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/refactorinqq/BridgeBase">Bridge Base</a> by <a rel="cc:attributionURL dct:creator" property="cc:attributionName" href="http://github.com/refactorinqq">Refactoring</a> is licensed under <a href="http://creativecommons.org/licenses/by/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">Attribution 4.0 International<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1"><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1"></a></p>

In short, you're allowed to:

- Modify this code
- Use it for commercial purposes

but you have to:

- Provide proper attribution to me.
