# designPatterns
设计模式示例
#### 总结软件设计模式的七大原则，如下表所示。

| 设计原则     | 一句话归纳                                                   | 目的                                       |
| ------------ | :----------------------------------------------------------- | ------------------------------------------ |
| 开闭原则     | 对扩展开放，对修改关闭                                       | 降低维护带来的新风险                       |
| 依赖倒置原则 | 高层不应该依赖低层，要面向接口编程                           | 更利于代码结构的升级扩展                   |
| 单一职责原则 | 一个类只干一件事，实现类要单一                               | 便于理解，提高代码的可读性                 |
| 接口隔离原则 | 一个接口只干一件事，接口要精简单一                           | 功能解耦，高聚合、低耦合                   |
| 迪米特法则   | 不该知道的不要知道，一个类应该保持对其它对象最少的了解，降低耦合度 | 只和朋友交流，不和陌生人说话，减少代码臃肿 |
| 里氏替换原则 | 不要破坏继承体系，子类重写方法功能发生改变，不应该影响父类方法的含义 | 防止继承泛滥                               |
| 合成复用原则 | 尽量使用组合或者聚合关系实现代码复用，少使用继承             | 降低代码耦合                               |


实际上，这些原则的目的只有一个：降低对象之间的耦合，增加程序的可复用性、可扩展性和可维护性。

 

##### 记忆口诀：访问加限制，函数要节俭，依赖不允许，动态加接口，父类要抽象，扩展不更改。

 

在程序设计时，我们应该将程序功能最小化，每个类只干一件事。若有类似功能基础之上添加新功能，则要合理使用继承。对于多方法的调用，要会运用接口，同时合理设置接口功能与数量。最后类与类之间做到低耦合高内聚。


##### GoF的23种设计模式的功能（简单工厂除外）

 

##### 1、单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。

优点：

1、单例模式可以保证内存里只有一个实例，减少了内存的开销。

2、可以避免对资源的多重占用。

3、单例模式设置全局访问点，可以优化和共享资源的访问。

缺点：

1、单例模式一般没有接口，扩展困难。如果要扩展，则除了修改原来的代码，没有第二种途径，违背开闭原则。

2、在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，也不能模拟生成一个新的对象。

3、单例模式的功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。

应用场景：

1、需要频繁创建的一些类，使用单例可以降低系统的内存压力，减少 GC。

2、某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。

3、某些类创建实例时占用资源较多，或实例化耗时较长，且经常使用。

4、某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。

5、频繁访问数据库或文件的对象。

6、对于一些控制硬件级别的操作，或者从系统上来讲应当是单一控制逻辑的操作，如果有多个实例，则系统会完全乱套。

7、当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。

 

##### 2、原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。

优点：

1、Java自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。

2、可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。

缺点：

1、需要为每一个类都配置一个 clone 方法

2、clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。

3、当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。

应用场景：

1、对象之间相同或相似，即只是个别的几个属性不同的时候。

2、创建对象成本较大，例如初始化时间长，占用CPU太多，或者占用网络资源太多等，需要优化资源。

3、创建一个对象需要繁琐的数据准备或访问权限等，需要提高性能或者提高安全性。

4、系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值。

 

##### 3、简单工厂模式：定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。

优点：

1、工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。

2、客户端无需知道所创建具体产品的类名，只需知道参数即可。

3、也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。

缺点：

1、简单工厂模式的工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。

2、使用简单工厂模式会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度

3、系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂

4、简单工厂模式使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。

应用场景：

1、对于产品种类相对较少的情况，考虑使用简单工厂模式。使用简单工厂模式的客户端只需要传入工厂类的参数，不需要关心如何创建对象的逻辑，可以很方便地创建所需产品。

 

##### 4、工厂方法（Factory Method）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。

优点：

1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。

2、灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。

3、典型的解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。

缺点：

1、类的个数容易过多，增加复杂度

2、增加了系统的抽象性和理解难度

3、抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。

应用场景：

1、客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。

2、创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。

3、客户不关心创建产品的细节，只关心产品的品牌

 

##### 5、抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。

优点：

1、可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。

2、当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。

3、抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。

 

缺点：

1、当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。

应用场景：

1、当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。

2、系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。

3、系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。

 

##### 6、建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。

优点：

1、封装性好，构建和表示分离。

2、扩展性好，各个具体的建造者相互独立，有利于系统的解耦。

3、客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。

缺点：

1、产品的组成部分必须相同，这限制了其使用范围。

2、如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。

应用场景：

1、相同的方法，不同的执行顺序，产生不同的结果。

2、多个部件或零件，都可以装配到一个对象中，但是产生的结果又不相同。

3、产品类非常复杂，或者产品类中不同的调用顺序产生不同的作用。

4、初始化一个对象特别复杂，参数多，而且很多参数都具有默认值。

 

##### 7、代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。

优点：

1、代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；

2、代理对象可以扩展目标对象的功能；

3、代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性。

缺点：

1、代理模式会造成系统设计中类的数量增加

2、在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；

3、增加了系统的复杂度；

应用场景：

1、远程代理，这种方式通常是为了隐藏目标对象存在于不同地址空间的事实，方便客户端访问。例如，用户申请某些网盘空间时，会在用户的文件系统中建立一个虚拟的硬盘，用户访问虚拟硬盘时实际访问的是网盘空间。

2、虚拟代理，这种方式通常用于要创建的目标对象开销很大时。例如，下载一幅很大的图像需要很长时间，因某种计算比较复杂而短时间无法完成，这时可以先用小比例的虚拟代理替换真实的对象，消除用户对服务器慢的感觉。

3、安全代理，这种方式通常用于控制不同种类客户对真实对象的访问权限。

4、智能指引，主要用于调用目标对象时，代理附加一些额外的处理功能。例如，增加计算真实对象的引用次数的功能，这样当该对象没有被引用时，就可以自动释放它。

5、延迟加载，指为了提高系统的性能，延迟对目标的加载。例如，Hibernate中就存在属性的延迟加载和关联表的延时加载。

 

##### 8、适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。

优点：

1、客户端通过适配器可以透明地调用目标接口。

2、复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。

3、将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。

4、在很多业务场景中符合开闭原则。

缺点：

1、适配器编写过程需要结合业务场景全面考虑，可能会增加系统的复杂性。

2、增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。

应用场景：

1、以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。

2、使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。

##### 9、桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

优点：

1、抽象与实现分离，扩展能力强

2、符合开闭原则

3、符合合成复用原则

4、其实现细节对客户透明

缺点：

1、由于聚合关系建立在抽象层，要求开发者针对抽象化进行设计与编程，能正确地识别出系统中两个独立变化的维度，这增加了系统的理解与设计难度。

应用场景：

1、当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。

2、当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。

3、当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。

 

##### 10、装饰（Decorator）模式：动态的给对象增加一些职责，即增加其额外的功能。

优点：

1、装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用。

2、通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果。

3、装饰器模式完全遵守开闭原则。

缺点：

1、装饰器模式会增加许多子类，过度使用会增加程序得复杂性。

应用场景：

1、当需要给一个现有类添加附加职责，而又不能采用生成子类的方法进行扩充时。例如，该类被隐藏或者该类是终极类或者采用继承方式会产生大量的子类。

2、当需要通过对现有的一组基本功能进行排列组合而产生非常多的功能时，采用继承关系很难实现，而采用装饰器模式却很好实现。

3、当对象的功能要求可以动态地添加，也可以再动态地撤销时。

 

##### 11、外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。

优点：

1、降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。

2、对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。

3、降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。

缺点：

1、不能很好地限制客户使用子系统类，很容易带来未知风险。

2、增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。

应用场景：

1、对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。

2、当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。

3、当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性。

 

##### 12、享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。

优点：

1、相同对象只要保存一份，这降低了系统中对象的数量，从而降低了系统中细粒度对象给内存带来的压力。

缺点：

1、为了使对象可以共享，需要将一些不能共享的状态外部化，这将增加程序的复杂性。

2、读取享元模式的外部状态会使得运行时间稍微变长。

应用场景：

1、系统中存在大量相同或相似的对象，这些对象耗费大量的内存资源。

2、大部分的对象可以按照内部状态进行分组，且可将不同部分外部化，这样每一个组只需保存一个内部状态。

3、由于享元模式需要额外维护一个保存享元的数据结构，所以应当在有足够多的享元实例时才值得使用享元模式。

 

##### 13、组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。

优点：

1、组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；

2、更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；

缺点：

1、设计较复杂，客户端需要花更多时间理清类之间的层次关系；

2、不容易限制容器中的构件；

3、不容易用继承的方法来增加构件的新功能；

应用场景：

1、在需要表示一个对象整体与部分的层次结构的场合。

2、要求对用户隐藏组合对象与单个对象的不同，用户可以用统一的接口使用组合结构中的所有对象的场合。

 

##### 14、模板方法（TemplateMethod）模式：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。

优点：

1、它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。

2、它在父类中提取了公共的部分代码，便于代码复用。

3、部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。

缺点：

1、对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象，间接地增加了系统实现的复杂度。

2、父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。

3、由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。

应用场景：

1、算法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。

2、当多个子类存在公共的行为时，可以将其提取出来并集中到一个公共父类中以避免代码重复。首先，要识别现有代码中的不同之处，并且将不同之处分离为新的操作。最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。

3、当需要控制子类的扩展时，模板方法只在特定点调用钩子操作，这样就只允许在这些点进行扩展。

 

##### 15、策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。

优点：

1、多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句，如 if...else 语句、switch...case 语句。

2、策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。

3、策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。

4、策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。

5、策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。

缺点：

1、客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。

2、策略模式造成很多的策略类，增加维护难度。

应用场景：

1、一个系统需要动态地在几种算法中选择一种时，可将每个算法封装到策略类中。

2、一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句。

3、系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时。

4、系统要求使用算法的客户不应该知道其操作的数据时，可使用策略模式来隐藏与算法相关的数据结构。

5、多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为。

 

##### 16、命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。

优点：

1、通过引入中间件（抽象接口）降低系统的耦合度。

2、扩展性良好，增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，且满足“开闭原则”。

3、可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。

4、方便实现 Undo 和 Redo 操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。

5、可以在现有命令的基础上，增加额外功能。比如日志记录，结合装饰器模式会更加灵活。

缺点：

1、可能产生大量具体的命令类。因为每一个具体操作都需要设计一个具体命令类，这会增加系统的复杂性。

2、命令模式的结果其实就是接收方的执行结果，但是为了以命令的形式进行架构、解耦请求与实现，引入了额外类型结构（引入了请求方与抽象命令接口），增加了理解上的困难。不过这也是设计模式的通病，抽象必然会额外增加类的数量，代码抽离肯定比代码聚合更加难理解。

应用场景：

1、请求调用者需要与请求接收者解耦时，命令模式可以使调用者和接收者不直接交互。

2、系统随机请求命令或经常增加、删除命令时，命令模式可以方便地实现这些功能。

3、当系统需要执行一组操作时，命令模式可以定义宏命令来实现该功能。

4、当系统需要支持命令的撤销（Undo）操作和恢复（Redo）操作时，可以将命令对象存储起来，采用备忘录模式来实现。

 

##### 17、职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。

优点：

1、降低了对象之间的耦合度。该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无须拥有对方的明确信息。

2、增强了系统的可扩展性。可以根据需要增加新的请求处理类，满足开闭原则。

3、增强了给对象指派职责的灵活性。当工作流程发生变化，可以动态地改变链内的成员或者调动它们的次序，也可动态地新增或者删除责任。

4、责任链简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。

5、责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。

缺点：

1、不能保证每个请求一定被处理。由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传到链的末端都得不到处理。

2、对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。

3、职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，如可能会造成循环调用。

应用场景：

1、多个对象可以处理一个请求，但具体由哪个对象处理该请求在运行时自动确定。

2、可动态指定一组对象处理请求，或添加新的处理者。

3、需要在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。

 

##### 18、状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。

优点：

1、结构清晰，状态模式将与特定状态相关的行为局部化到一个状态中，并且将不同状态的行为分割开来，满足“单一职责原则”。

2、将状态转换显示化，减少对象间的相互依赖。将不同的状态引入独立的对象中会使得状态转换变得更加明确，且减少对象间的相互依赖。

3、状态类职责明确，有利于程序的扩展。通过定义新的子类很容易地增加新的状态和转换。

缺点：

1、状态模式的使用必然会增加系统的类与对象的个数。

2、状态模式的结构与实现都较为复杂，如果使用不当会导致程序结构和代码的混乱。

3、状态模式对开闭原则的支持并不太好，对于可以切换状态的状态模式，增加新的状态类需要修改那些负责状态转换的源码，否则无法切换到新增状态，而且修改某个状态类的行为也需要修改对应类的源码。

应用场景：

1、当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为时，就可以考虑使用状态模式。

2、一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时。

 

##### 19、观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。

优点：

1、降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。

2、目标与观察者之间建立了一套触发机制。

缺点：

1、目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。

2、当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率。

应用场景：

1、对象间存在一对多关系，一个对象的状态发生改变会影响其他对象。

2、当一个抽象模型有两个方面，其中一个方面依赖于另一方面时，可将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。

3、实现类似广播机制的功能，不需要知道具体收听者，只需分发广播，系统中感兴趣的对象会自动接收该广播。

4、多层级嵌套使用，形成一种链式触发机制，使得事件具备跨域（跨越两种观察者类型）通知。

 

##### 20、中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。

优点：

1、类之间各司其职，符合迪米特法则。

2、降低了对象之间的耦合性，使得对象易于独立地被复用。

3、将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。

缺点：

1、中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越臃肿，变得复杂且难以维护。

应用场景：

1、当对象之间存在复杂的网状结构关系而导致依赖关系混乱且难以复用时。

2、当想创建一个运行于多个类之间的对象，又不想生成新的子类时。

 

##### 21、迭代器（Iterator）模式：提供一种方法来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。

优点：

1、访问一个聚合对象的内容而无须暴露它的内部表示。

2、遍历任务交由迭代器完成，这简化了聚合类。

3、它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。

4、增加新的聚合类和迭代器类都很方便，无须修改原有代码。

5、封装性良好，为遍历不同的聚合结构提供一个统一的接口。

缺点：

1、增加了类的个数，这在一定程度上增加了系统的复杂性。

应用场景：

1、当需要为聚合对象提供多种遍历方式时。

2、当需要为遍历不同的聚合结构提供一个统一的接口时。

3、当访问一个聚合对象的内容而无须暴露其内部细节的表示时。

 

##### 22、访问者（Visitor）模式：在不改变集合元素的前提下，为一个集合中的每个元素提供多种访问方式，即每个元素有多个访问者对象访问。

优点：

1、扩展性好。能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。

2、复用性好。可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度。

3、灵活性好。访问者模式将数据结构与作用于结构上的操作解耦，使得操作集合可相对自由地演化而不影响系统的数据结构。

4、符合单一职责原则。访问者模式把相关的行为封装在一起，构成一个访问者，使每一个访问者的功能都比较单一。

缺点：

1、增加新的元素类很困难。在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”。

2、破坏封装。访问者模式中具体元素对访问者公布细节，这破坏了对象的封装性。

3、违反了依赖倒置原则。访问者模式依赖了具体类，而没有依赖抽象类。

应用场景：

1、对象结构相对稳定，但其操作算法经常变化的程序。

2、对象结构中的对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构。

3、对象结构包含很多类型的对象，希望对这些对象实施一些依赖于其具体类型的操作。

 

##### 23、备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。

优点：

1、提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。

2、实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。

3、简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则。

 

缺点：

4、资源消耗大。如果要保存的内部状态信息过多或者特别频繁，将会占用比较大的内存资源。

应用场景：

5、需要保存与恢复数据的场景，如玩游戏时的中间结果的存档功能。

6、需要提供一个可回滚操作的场景，如 Word、记事本、Photoshop，Eclipse 等软件在编辑时按 Ctrl+Z 组合键，还有数据库中事务操作。

 

##### 24、解释器（Interpreter）模式：提供如何定义语言的文法，以及对语言句子的解释方法，即解释器。

优点：

1、扩展性好。由于在解释器模式中使用类来表示语言的文法规则，因此可以通过继承等机制来改变或扩展文法。

2、容易实现。在语法树中的每个表达式节点类都是相似的，所以实现其文法较为容易。

缺点：

1、执行效率较低。解释器模式中通常使用大量的循环和递归调用，当要解释的句子较复杂时，其运行速度很慢，且代码的调试过程也比较麻烦。

2、会引起类膨胀。解释器模式中的每条规则至少需要定义一个类，当包含的文法规则很多时，类的个数将急剧增加，导致系统难以管理与维护。

3、可应用的场景比较少。在软件开发中，需要定义语言文法的应用实例非常少，所以这种模式很少被使用到。

应用场景：

1、当语言的文法较为简单，且执行效率不是关键问题时。

2、当问题重复出现，且可以用一种简单的语言来进行表达时。

3、当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候，如 XML 文档解释。



#### 总结

- ~~~yml
  # ~~~代表与上面的一样
  ~~~

| 分类                                          | 设计模式                                      | 简述                                                         | 一句话归纳                     | 目的                   | 生活案例       |
| --------------------------------------------- | --------------------------------------------- | ------------------------------------------------------------ | ------------------------------ | ---------------------- | -------------- |
| 创建型设计模式 （简单来说就是用来创建对象的） | 工厂模式（Factory Pattern）                   | 不同条件下创建不同实例                                       | 产品标准化，生产更高效         | 封装创建细节           | 实体工厂       |
| ~ ~~                                          | 单例模式（Singleton Pattern）                 | 保证一个类仅有一个实例，并且提供一个全局访问点               | 世上只有一个我                 | 保证独一无二           | CEO            |
| ~~~                                           | 原型模式（Prototype Pattern）                 | 通过拷贝原型创建新的对象                                     | 拔一根猴毛，吹出千万个         | 高效创建对象           | 克隆           |
| ~~~                                           | 建造者模式（Builder Pattern）                 | 用来创建复杂的复合对象                                       | 高配中配和低配，想选哪配就哪配 | 开放个性配置步骤       | 选配           |
| 结构型设计模式 （关注类和对象的组合）         | 代理模式（Proxy Pattern）                     | 为其他对象提供一种代理以控制对这个对象的访问                 | 没有资源没时间，得找别人来帮忙 | 增强职责               | 媒婆           |
| ~~~                                           | 外观模式（Facade Pattern）                    | 对外提供一个统一的接口用来访问子系统                         | 打开一扇门，通向全世界         | 统一访问入口           | 前台           |
| ~~~                                           | 装饰器模式（Decorator Pattern）               | 为对象添加新功能                                             | 他大舅他二舅都是他舅           | 灵活扩展、同宗同源     | 煎饼           |
| ~~~                                           | 享元模式（Flyweight Pattern）                 | 使用对象池来减少重复对象的创建                               | 优化资源配置，减少重复浪费     | 共享资源池             | 全国社保联网   |
| ~~~                                           | 组合模式（Composite Pattern）                 | 将整体与局部（树形结构）进行递归组合，让客户端能够以一种的方式对其进行处理 | 人在一起叫团伙，心在一起叫团队 | 统一整体和个体         | 组织架构树     |
| ~~~                                           | 适配器模式（Adapter Pattern）                 | 将原来不兼容的两个类融合在一起                               | 万能充电器                     | 兼容转换               | 电源适配       |
| ~~~                                           | 桥接模式（Bridge Pattern）                    | 将两个能够独立变化的部分分离开来                             | 约定优于配置                   | 不允许用继承           | 桥             |
| 行为型设计模式 （关注对象之间的通信）         | 模板模式（Template Pattern）                  | 定义一套流程模板，根据需要实现模板中的操作                   | 流程全部标准化，需要微调请覆盖 | 逻辑复用               | 把大象装进冰箱 |
| ~~~                                           | 策略模式（Strategy Pattern）                  | 封装不同的算法，算法之间能互相替换                           | 条条大道通罗马，具体哪条你来定 | 把选择权交给用户       | 选择支付方式   |
| ~~~                                           | 责任链模式（Chain of Responsibility Pattern） | 拦截的类都实现统一接口，每个接收者都包含对下一个接收者的引用。将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。 | 各人自扫门前雪，莫管他们瓦上霜 | 解耦处理逻辑           | 踢皮球         |
| ~~~                                           | 迭代器模式（Iterator Pattern）                | 提供一种方法顺序访问一个聚合对象中的各个元素                 | 流水线上坐一天，每个包裹扫一遍 | 统一对集合的访问方式   | 逐个检票进站   |
| ~~~                                           | 命令模式（Command Pattern）                   | 将请求封装成命令，并记录下来，能够撤销与重做                 | 运筹帷幄之中，决胜千里之外     | 解耦请求和处理         | 遥控器         |
| ~~~                                           | 状态模式（State Pattern）                     | 根据不同的状态做出不同的行为                                 | 状态驱动行为，行为决定状态     | 绑定状态和行为         | 订单状态跟踪   |
| ~~~                                           | 备忘录模式（Memento Pattern）                 | 保存对象的状态，在需要时进行恢复                             | 失足不成千古恨，想重来时就重来 | 备份、后悔机制         | 草稿箱         |
| ~~~                                           | 中介者模式（Mediator Pattern）                | 将对象之间的通信关联关系封装到一个中介类中单独处理，从而使其耦合松散 | 联系方式我给你，怎么搞定我不管 | 统一管理网状资源       | 朋友圈         |
| ~~~                                           | 解释器模式（Interpreter Pattern）             | 给定一个语言，定义它的语法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子 | 我想说”方言“，一切解释权都归我 | 实现特定语法解析       | 摩斯密码       |
| ~~~                                           | 观察者模式（Observer Pattern）                | 状态发生改变时通知观察者，一对多的关系                       | 到点就通知我                   | 解耦观察者与被观察者   | 闹钟           |
| ~~~                                           | 访问者模式（Visitor Pattern）                 | 稳定数据结构，定义新的操作行为                               | 横看成岭侧成峰，远近高低各不同 | 解耦数据结构和数据操作 | KPI考核        |
|                                               | 委派模式（Delegate Pattern）                  | 允许对象组合实现与继承相同的代码重用，负责任务的调用和分配   | 这个需求很简单，怎么实现我不管 | 只对结果负责           | 授权委托书     |
