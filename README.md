# Kotlin/JS with Tailwind CSS

A Gradle project template integrating [Kotlin/JS](https://kotlinlang.org/docs/js-overview.html) and [Tailwind CSS](https://tailwindcss.com/) with support for _continuous mode_ and _live reloading_.

## Continuous mode

Run:

    ./gradlew jsRun -t

Edit `input.css`, Kotlin source files and HTML resources at will. Everything should _live reload_ upon save.

## Customizing the template

After creating a new project from this template you might want to:

- Change the root project name in `settings.gradle.kts`;
- Change the name of the included JavaScript file to match the new root project name.

## Publishing the resulting website to GitHub Pages

This template includes a [workflow](.github/workflows/publish.yml) that automatically publishes a production build of the project upon every push to the `main` branch.

For this to work, your GitHub project repository must be configured to allow _build and deployment_ of GitHub Pages by _GitHub Actions_, see [Publishing with a custom GitHub Actions workflow](https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site#publishing-with-a-custom-github-actions-workflow) for details.
