+++
title = "Simplifying Learning: ShardingSphere’s Template Engine for Streamlined Examples"
weight = 98
chapter = true 
+++


![img](https://shardingsphere.apache.org/blog/img/2023_05_10_Simplifying_Learning_ShardingSphere’s_Template_Engine_for_Streamlined_Examples.en.md1.jpeg)

After years of rapid development, ShardingSphere has grown significantly, offering six core functional modules that cater to various needs. It is also compatible with different registries, such as ZooKeeper and Nacos, allowing for seamless integration. Moreover, it supports distributed transactions and various development frameworks, providing flexibility and convenience.

To ensure a user-friendly experience, we have created an example module that showcases the diverse functionalities, registries, and service frameworks of ShardingSphere.

This example system serves as a demonstration of how these components can be effectively combined, along with an abstraction of business logic. Take a look at the illustration of our example system below:

![img](https://shardingsphere.apache.org/blog/img/2023_05_10_Simplifying_Learning_ShardingSphere’s_Template_Engine_for_Streamlined_Examples.en.md2.jpeg)

# Analyzing the Issue


Let me start by showing you the structure of Yogiyo’s order service. When order creation, cancellation, or update traffic occurs, the Orderyo application code distributes the write load to four shard clusters based on the `customer_id`. This way, the application only needs the `customer_id` to find the shard cluster it needs to access and perform the operation.

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md2.jpeg)Figure 1 — ShardingSphere’s former example directory structure

# Enhancing the Example Module for Improved User Experience

The example module of ShardingSphere has undergone significant evolution, incorporating a wide range of functionality. However, this growth has resulted in challenges for users, including difficulties in quickly finding the desired example and comprehending the shared business logic code.

After extensive discussions within the community, we have identified several key issues with the current examples:

**1. Lack of Representation:** The example modules fail to clearly represent the features and structure of ShardingSphere, as they utilize a different abstraction level than the ShardingSphere module hierarchy. This discrepancy causes confusion among users.

**2. Complexity of Business Code:** The reliance on complex, generic, and abstract public business code poses a significant learning obstacle for users. The abundance of such code makes it challenging to grasp the core concepts effectively.

**3. Non-standardized Configuration:** The configuration approach employed in the current examples lacks standardization and is predominantly focused on logic handling rather than leveraging the native capabilities of ShardingSphere. This limitation restricts the system’s ability to support a broad range of scenarios.

**4. Limited Sample Portfolio:** The existing sample portfolio is relatively small and lacks the necessary flexibility to cater to different service frameworks and modules, such as JDBC and spring boot + JDBC. This limitation restricts the versatility and applicability of ShardingSphere.

**5. Proxy Example Focus:** The ShardingSphere Proxy example should prioritize configuration guidance over the introduction of numerous logical examples. This shift will enable users to better understand and utilize the Proxy example effectively.

To address these concerns and provide users with an enhanced and intuitive experience, we are actively working on refining the example module of ShardingSphere. Our implementation principle is based on the following key considerations:

**1. Flexibility and Combinability:**  Our goal is to enable users to freely combine and select the modules and features they require for ShardingSphere, allowing for different combinations.

**2. Modularization and Preformatting:** Through thorough analysis and research, we have disassembled the ShardingSphere modules into minimal combinable units. These units have been preformatted in various scenarios using the [FreeMarker template engine](https://freemarker.apache.org/). When users select a specific scenario combination, the corresponding example project is automatically generated by extracting the relevant logical units.

By implementing these improvements, we empower users to easily navigate and understand the examples, while providing the necessary flexibility to adapt ShardingSphere to their specific needs. Figure 2 illustrates the smallest logical unit of the encryption module within this new approach.

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md3.jpeg)Figure 2 — Minimum logical unit of the encryption module


# Improved Flexibility and Reduced Learning Cost

To enhance the flexibility and user experience of the example module, we have taken a step further by splitting the smallest logical unit of functional code. This enables users to combine functional features according to their specific requirements, providing on-demand access.

Additionally, we have addressed the issue of complex business code by templating the original public business logic. By removing the abstract logic and reducing the learning cost, users can easily understand and utilize the examples.

Figure 3 illustrates how these improvements have been implemented:

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md4.jpeg)Figure 3 — Public business logic templates


In the updated approach, the core functional modules’ code logic has been split into smaller, more manageable units. These units can be seamlessly combined based on the user’s choice, allowing for a customized experience.

Furthermore, the abstract logic of the business code has been streamlined through the use of templates. This approach significantly reduces the complexity and learning curve for users, ensuring a smoother onboarding process.

With these enhancements, users can effectively navigate the example module, freely select the desired features, and swiftly grasp the underlying concepts.

Additionally, we have divided the functional features into categories like encryption and decryption, read/write splitting, and database and table separation. The supported configuration types are outlined in detail in Table 1.

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md5.jpeg)


Based on the configuration types we abstracted, the module names of the sample module code were sorted and redefined to make it easier for users to find and use. This is shown below:

```
shardingsphere-${product}-sample/${feature}--${framework}--${mode}--${transaction}
```

In summary, the updated example module leverages the power of the FreeMarker template engine. This approach significantly enhances flexibility by splitting the functional code into minimal logical units, abstracting business templates with business code, and standardizing module names. The result is a highly flexible example module that offers improved organization and usability:

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md6.jpeg)Figure 4 — Example generation engine logic structure


Each module generated within this framework is a standalone project, allowing for individual testing and independent use. This approach ensures that users can effectively utilize and validate the functionality of each module according to their specific requirements.


# Using the Example Generation Module

## 1. Locate the Example Generation Module

Navigate to the [ShardingSphere project directory](https://github.com/apache/shardingsphere) and find the `shardingsphere-jdbc-example-generator` module within the corresponding example module. This module contains all the template files and generation logic required for generating examples.

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md6.jpeg)Figure 5 — Project structure of the generation engine


## 2. Configure the Generation Engine Parameters

The `shardingsphere-jdbc-example-generator` module is a standard Java project. The project's configuration file can be found at `resources/config.yaml`. This file allows users to declare various parameters supported by the generation engine. In addition to the template parameters for specific functions, we have also provided convenient configurations that users can customize according to their needs. The specific parameters and their meanings are outlined in Table 2:

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md7.jpeg)

## 3. Generate the Configuration Module

After configuring the parameters, it’s time to generate the corresponding configuration module. This can be done in two ways:

- **Running the Main Class:** Locate the `ExampleGeneratorMain` class under the `shardingsphere-jdbc-example-generator` module and run the main method. This will generate the example in the configured output directory.

- **Using Maven Command Line:** Alternatively, you can use the Maven command line to trigger the generation process. The command should be executed as follows:

```
// generate configuration based on config.yaml
./mvnw -B clean install -f examples/shardingsphere-jdbc-example-generator/pom.xml -Pexample-generator

// generation configuration based on command parameters
./mvnw -B clean install -f examples/shardingsphere-jdbc-example-generator/pom.xml -Pexample-generator -Dproducts=jdbc -Dmodes=cluster-zookeeper -Dtransactions=local -Dfeatures=shadow -Dframeworks=jdbc
```

## 4. View and Utilize the Examples

Once the generation process is triggered, the associated example code will be generated in the configured output directory. Typically, this would be in the `shardingsphere-jdbc-example-generator/target/generated-sources/ directory`. The generated directory structure can be seen in Figure 6 below:

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md8.jpeg)Figure 6 — Directory structure for generating examples

Within the generated directory, each project module is a standard Maven project. You can directly open it using an IDE like IntelliJ IDEA, and run the project. This will result in a project structure as shown in Figure 7:

![img](https://shardingsphere.apache.org/blog/img/2023_04_27_How_South_Korea’s_Yogiyo_Improved_Scalability_and_Performance_with_Apache_ShardingSphere.en.md9.jpeg)Figure 7 — Generated example project structure

By following these steps, you can effectively use the example generation module to generate the desired configuration modules and leverage the provided examples to enhance your understanding and utilization of ShardingSphere.

# Introducing the JDBC Example and Future Improvements

We are pleased to announce that we have successfully implemented the template engine for generating example code. As a result, we have developed the initial version of the JDBC example. However, we acknowledge that the current example is relatively basic in terms of the disassembled minimum logical unit. It is also relatively simple and focuses on a single scenario. To provide a more comprehensive and flexible experience, we plan to make further refinements.

## Our future plans include:

1. Enhancing the Minimum Logical Unit: We aim to break down the code into smaller and more granular logical units. This will provide users with greater flexibility to combine and configure the desired functionality according to their specific requirements.

2. Adding Additional Configurations: We recognize the need to incorporate more configurations to cater to a wider range of use cases. By expanding the available configuration options, users will have a more comprehensive set of tools at their disposal.

3. Improving Usage Documentation: We understand the importance of clear and concise documentation. We will focus on enhancing the documentation to ensure users can easily understand and utilize the features of ShardingSphere.


We appreciate your interest and support in making ShardingSphere better and more powerful. Your participation is invaluable as we strive to improve the flexibility, completeness, and overall user experience of ShardingSphere. Together, we can shape a robust and user-friendly platform that meets the diverse needs of the community.

















