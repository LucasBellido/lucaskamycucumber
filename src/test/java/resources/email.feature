Feature: Email

  Scenario: Sending an email after attaching an image
    Given I am on the Outlook main page
    When I press "New Message"
    And Enter a valid recipient
    And Attach an Image
    Then I should be able to press "Send"
    And The message successfully sends


  Scenario: Sending an email after attaching an image as OneDrive Link
    Given I am on the Outlook main page
    When I press "New Message"
    And Enter a valid recipient
    And Attach an Image as OneDrive Link
    Then I should be able to press "Send"
    And The message successfully sends

  Scenario: Sending an email from drafts
    Given I am on the Outlook main page
    When I press "Drafts"
    And a previous draft of my valid email exists
    Then I should be able to press "Send"
    And The message successfully sends

  Scenario: Attaching an image that is too large
    Given I am on the Outlook main page
    When I press "New Message"
    And Enter a valid recipient
    And Attach an image that is too large
    Then I shouldn’t be able to add the image as attachment

  Scenario: Sending to an invalid recipient
    Given I am on the Outlook main page
    When I press "New Message"
    And Enter an invalid recipient
    And Attach an Image
    Then I should be able to press "Send"
    And An error message exists indicating that the recipient is invalid


