# Codebase Task Proposals

## 1) Typo fix task
**Issue:** In Extent report metadata, host name is set to `Localhost` (capital `L`), while the conventional value is `localhost`. This is a small textual inconsistency that can make environment metadata look unpolished.

**Proposed task:** Update `extent.setSystemInfo("Host Name", "Localhost")` to `extent.setSystemInfo("Host Name", "localhost")` in `ExtentReportListener`.

**Why this matters:** Improves consistency and report professionalism with a minimal, low-risk change.

---

## 2) Bug fix task
**Issue:** `BaseTest#setUp` does not handle unsupported browser values. If `browser` is anything other than `chrome`, `firefox`, or `edge`, `driver` remains `null`, and tests may fail later with unclear errors.

**Proposed task:** Add explicit validation and fail fast by throwing an `IllegalArgumentException` (or `RuntimeException`) when an unsupported browser is configured.

**Why this matters:** Converts a latent null-driver failure into an immediate, actionable configuration error.

---

## 3) Comment/documentation discrepancy task
**Issue:** `LoginTest#testLoginWithData` contains comments saying an invalid-credentials assertion should be added, but the test only checks URL contains `login`. The comment and implementation are misaligned.

**Proposed task:** Replace the TODO-style comments with accurate documentation of current behavior, or implement the missing assertion and then update comments accordingly.

**Why this matters:** Reduces confusion and keeps in-code documentation aligned with actual test intent.

---

## 4) Test improvement task
**Issue:** The invalid-login branch in `LoginTest#testLoginWithData` only checks URL remains on login page, which is weak and can pass despite UI/API issues.

**Proposed task:** Add a page-object locator and assertion for the `Invalid credentials` error banner/text, and assert its visibility/text for negative test data.

**Why this matters:** Makes the negative-path test meaningful and less flaky by validating user-visible error behavior directly.
