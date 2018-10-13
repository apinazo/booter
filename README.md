# bootbase
Spring Boot base app for projects

## Technology

Based on Spring Boot 2.

## Versioning

This project follows [Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).

Why did I choose Gitflow?

* I wanted it to be a clear example of how to use this versioning flow.
* It helps me having a clean line of work.

## Package structure

The project follows a [package by feature](https://dzone.com/articles/package-by-layer-for-spring-projects-is-obsolete?edition=365203&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202018-02-28) structure. This offers many advantages:

* It's easier to understand.
* It scales better.
* Decouples functional areas.
* Avoid the big mess of having dozens of files on each package when the structure is layer based.
* Prepares the application to eventual separation into microservices.

The traditional package by layer structure is now obsolete.
