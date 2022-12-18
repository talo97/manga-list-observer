## Main assumptions:

- System works as manga aggregator which allows user to observe selected manga and provides notification when new
  chapter of observed comics appear.
- System don't copy any of the supported websites chapters and only provides links for easier navigation.
- Every manga can have multiple sites that are providing chapters.
- Each chapter can have multiple links for its viewing.
- There is chapter validation service for newest chapters, as they might be fetched incorrectly.

## Use case:

### List

- List all manga in the system
- List all manga supported by selected website
- List all manga

### Search

- Search for new manga entry for each website
- Search for new chapters for each manga in every website
- Validate previously added chapters
  > Validation is required because sometimes chapters are reposted in the observed websites for various reasons.
  > New chapters are more likely to change and due to this fact they should be validated more frequently than older ones.

### User (for now emitted)

- Register
- Login
- Change password

### Observe (user operations)

- Remember last read chapter of manga
- Check chapter as read
- Add manga to observed
- Remove manga from observed
- Assign stalled or dropped status to manga
- Remember previously observed manga
