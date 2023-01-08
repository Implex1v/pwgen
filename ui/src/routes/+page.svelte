<script lang="ts">
    import type PasswordEvent from "../components/PasswordGenerator.svelte";
    import PasswordCard from "../components/PasswordCard.svelte";
    import PasswordGenerator from "../components/PasswordGenerator.svelte";

    let passwords = [];

    async function addPassword(event: CustomEvent<PasswordEvent>) {
        passwords.push(event.detail.password);
        passwords = passwords;
    }
</script>

<p class="text-3xl py-4">Generate Password</p>

<div class="py-2">
    <PasswordGenerator on:password={addPassword} />
</div>

<p class="text-2xl py-4">History</p>

{#each passwords as password}
    <PasswordCard password={password} />
{/each}