# Roadmap for ESAPI 3.0.0

## Google-SoC Tasks

### Provide implementations of the interfaces (in a seperate project, as a standalone component) that implements the following interfaces
  
* Encoder
* Validator
* Authenticator
* AccessController
  
These implementations can be wrappers around existing tools, the primary purpose of this exercise is to evaluate the provided APIs to ensure that the interfaces are usable to developers. 
  
### Test Suite

ESAPI 3.0.0 will provide an additional component (ESTAPI - thanks to Dinis Cruz for the name) which will allow implementors to run tests against their implementations of a given control to ensure that it is in fact implemented securely. For GSoC I would like to focus this effort on a set of concrete tests for the Validator and Encoder interfaces as well as a fuzz test against both of those interfaces as well. Propose a design for how the tests will function and be run, then create a new repository (and link back to ESAPI/esapi-java) with your implementation.
  
### Centralized Security Policy Manager

One of the things that ESAPI aimed to provide was a means to enforce a centrally managed enterprise security policy in a provable way. Propose an idea and implement a proof-of-concept using the following design concepts:
  
* The enterprise security policy should be published in a parseable format - it can be XML, JSON, or any other schema based language.
* The enterprise security policy should allow downstream configuration overrides, but provide a audit event indicating a policy item has been overridden by a child policy
* The enterprise security policy should have a simple interface for configuration of the policy parameters, and should provide sane defaults for all controls

## Release Goals

1. *Design Verification* - Interfaces should be fairly locked down at the first release. The interfaces should be tested thoroughly by implementing a baseline set of components *and* testing inclusion of those components in real-world applications. 
1. *Solid interface documentation* - All interfaces should be fully documented in Javadoc
1. *Component Community Library* - An Apple Store'esque implementation of a community containing reviewed and approved controls that implementors can pull into their projects
1. *Discovery* - The ESAPI should provide a discovery module that discovers, registers, and configures controls (according to the enterprise security policy) - this can function similar to OSGi
1. *ESTAPI* - A full suite of tests that can provide assurance that controls are implemented correctly. ESTAPI testing will be a pre-requisite to inclusion in the Component Community Library.
