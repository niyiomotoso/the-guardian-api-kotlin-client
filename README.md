# The Guardian API Kotlin Client

Kotlin client library for the Guardian APIs. See documentation [here](https://open-platform.theguardian.com/documentation/).
All available API modules are supported - Content, Tags, Sections, Editions, and Single Item.

### Get API key

Sign up for an API key [here](https://open-platform.theguardian.com/access)

### Making Requests

The primary `Client\GuardianApi` class is a factory class that creates objects for each of the API modules, allowing you to make requests to any of them with your desired request parameters. You have to first create an object for it, then access your desired API module via the object. See the code snippets below:

```kotlin
val guardianApi = GuardianApi("9cb97729-b42b-4c0a-832a-84cc03c43841")
```

**For Content:**

```kotlin
val response = this.guardianApi.content().setQuery("12 years a slave")
    .setTag("film/film,tone/reviews")
    .setFromDate("2023-03-20")
    .setShowTags("contributor")
    .setShowFields("starRating,headline,thumbnail,short-url")
    .setOrderBy("relevance").fetch()
```

**For Tags:**

```kotlin
val response = this.guardianApi.tags().setQuery("apple")
    .setSection("technology")
    .setShowReferences("all").fetch()

```

**For Sections:**

```kotlin
val response = this.guardianApi.sections().setQuery("business").fetch()
```

**For Editions:**

```kotlin
val response = this.guardianApi.editions().setQuery("uk").fetch()
```

**For Single Item:**

```kotlin
val response = this.guardianApi.singleItem().setId("/sport/2022/oct/07/cricket-jos-buttler-primed-for-england-comeback-while-phil-salt-stays-focused")
        .setShowStoryPackage(true)
        .setShowEditorsPicks(true)
        .setShowMostViewed(true)
        .setShowRelated(true).fetch()
```